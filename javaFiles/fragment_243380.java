mQuickAction.setOnActionItemClickListener(new QuickAction.OnActionItemClickListener() {
    @Override
    public void onItemClick(QuickAction quickAction, int pos, int actionId) {
        ActionItem actionItem = quickAction.getActionItem(pos);
        File file = fileManager.getFile();

        switch (actionId) {
            case ID_EDIT:
                Toast.makeText(MainActivity.this, "go", Toast.LENGTH_SHORT).show();
                break;
            case ID_DELETE:
                Toast.makeText(MainActivity.this, "Delete book", Toast.LENGTH_SHORT).show();
                break;
            }
        }
    });

    ...
});