public class BaseCustomFragment extends Fragment implements OnItemClickListener, OnItemLongClickListener
{

    private List<MenuItemAction> menus = new ArrayList<MenuItemAction>();

    // base class for all actions for context-menu in BaseCustomFragment 
    abstract class MenuItemAction implements MenuItem.OnMenuItemClickListener
    {
        private final String title;

        public MenuItemAction(String title)
        {
            this.title = title;
        }

        public String getTitle()
        {
            return title;
        }

        public final boolean isVisible()
        {
            return isVisibleImpl(conCon, locCon);
        }

        @Override
        public final boolean onMenuItemClick(MenuItem item)
        {
            AdapterContextMenuInfo info = (AdapterContextMenuInfo) item.getMenuInfo();
            Log.d("MenuItem", "menu item '" + title + "' for #" + info.position + " of  " + BaseCustomFragment.this.getClass().getSimpleName());
            handleActionImpl(conCon, locCon);
            return true;
        }

        protected final void startActivity(Uri uri)
        {
            startActivity(Intent.ACTION_VIEW, uri);
        }

        protected final void startActivity(String action, Uri uri)
        {
            startActivity(new Intent(action, uri));
        }

        protected final void startActivity(Class<? extends Activity> activityClass)
        {
            startActivity(new Intent(getActivity(), activityClass));
        }

        protected final void startActivity(Intent intent)
        {
            getActivity().startActivity(intent);
        }

        protected abstract boolean isVisibleImpl(Customer conCon, Localization locCon);

        protected abstract void handleActionImpl(Customer conCon, Localization locCon);

    }

    protected void setContext(Customer c, Localization l)
    {
        Log.d("BaseFrag", "setContext class:" + String.valueOf(this.getClass()));
        Log.d("BaseFrag", "setContext :" + String.valueOf(l));
        conCon = c;
        locCon = l;
        Log.d("BaseFrag", "setContext2 :" + String.valueOf(locCon));
        updateContextMenu();
    }

    protected void setMenus(MenuItemAction... menuItems)
    {
        this.menus = Arrays.asList(menuItems);
        updateContextMenu();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo info)
    {
        super.onCreateContextMenu(menu, v, info);

        for (MenuItemAction menuItemAction : menus)
        {
            if (menuItemAction.isVisible())
            {
                MenuItem menuItem = menu.add(menuItemAction.getTitle());
                menuItem.setOnMenuItemClickListener(menuItemAction);
            }
        }
    }


    private void updateContextMenu()
    {
        if (lv == null)
            return;
        boolean hasVisibleItems = false;
        for (MenuItemAction menuItemAction : menus)
        {
            if (menuItemAction.isVisible())
            {
                hasVisibleItems = true;
                break;
            }
        }
        if (hasVisibleItems)
        {
            Log.d(getClass().getSimpleName(), "Attaching context menu for " + getClass().getSimpleName());
            this.registerForContextMenu(lv);
        }
        else
        {
            Log.d(getClass().getSimpleName(), "Detaching context menu for " + getClass().getSimpleName());
            this.unregisterForContextMenu(lv);
        }
    }