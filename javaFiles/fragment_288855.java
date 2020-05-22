protected MenuItemAction createNavigateToLocationMenuItem()
    {
        return new MenuItemAction("Navigate to location")
        {
            @Override
            protected boolean isVisibleImpl(Customer conCon, Localization locCon)
            {
                return (locCon != null);
            }

            @Override
            protected void handleActionImpl(Customer conCon, Localization locCon)
            {
                startActivity(Uri.parse("google.navigation:q=" + Uri.encode(locCon.noZipString())));
            }
        };
    }

    protected MenuItemAction createCallMenuItem()
    {
        return new MenuItemAction("Call")
        {
            @Override
            protected boolean isVisibleImpl(Customer conCon, Localization locCon)
            {
                return (conCon != null) && (conCon.getPhoneNumbers().size() > 0);
            }

            @Override
            protected void handleActionImpl(Customer conCon, Localization locCon)
            {
                startActivity(Intent.ACTION_DIAL, Uri.parse("tel:" + Uri.encode(BaseCustomFragment.this.conCon.getPhoneNumbers().get(0).toString())));
            }
        };
    }

    protected MenuItemAction createSmsMenuItem()
    {
        return new MenuItemAction("SMS")
        {
            @Override
            protected boolean isVisibleImpl(Customer conCon, Localization locCon)
            {
                return (conCon != null) && (conCon.getPhoneNumbers().size() > 0);
            }

            @Override
            protected void handleActionImpl(Customer conCon, Localization locCon)
            {
                startActivity(Uri.parse("sms:" + Uri.encode(BaseCustomFragment.this.conCon.getPhoneNumbers().get(0).toString())));
            }
        };
    }

    protected MenuItemAction createEmailMenuItem()
    {
        return new MenuItemAction("Email")
        {
            @Override
            protected boolean isVisibleImpl(Customer conCon, Localization locCon)
            {
                return (conCon != null) && (conCon.getEmail().length() > 0);
            }

            @Override
            protected void handleActionImpl(Customer conCon, Localization locCon)
            {
                startActivity(Uri.parse("mailto:" + Uri.encode(conCon.getEmail())));
            }
        };
    }

    protected MenuItemAction createNewOrderMenuItem()
    {
        return new MenuItemAction("New Order")
        {
            @Override
            protected boolean isVisibleImpl(Customer conCon, Localization locCon)
            {
                return true;
            }

            @Override
            protected void handleActionImpl(Customer conCon, Localization locCon)
            {
                startActivity(OrderActivity.class);
            }
        };
    }