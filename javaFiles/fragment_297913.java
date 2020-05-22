@Override
    public boolean onOptionsItemSelected(MenuItem menu) {
        switch (menu.getItemId()) {
        case R.id.menuitem:
            startActivity(new Intent(this, Prefs.class));
            break;

case R.id.menuitem1:
            startActivity(new Intent(this, Prefs1.class));
            break;
        default:
            break;
        }

        return true;
    }