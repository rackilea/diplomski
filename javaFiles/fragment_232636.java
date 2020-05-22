mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch(position) {
            case 0:     // Pos (0) of your osArray 
                startActivity(new Intent(this, AndroidActivity.class));
                break
            case 1:     // Pos (1) of your osArray... etc. 
                startActivity(new Intent(this, IosActivity.class));
                break;
            case 2:
                startActivity(new Intent(this, WindowsActivity.class));
                break;
            case 3:
                startActivity(new Intent(this, OsxActivity.class));
                break;
            case 4:
                startActivity(new Intent(this, LinuxActivity.class));
                break;
            default:
                Toast.makeText(MainActivity.this, "No such activity.", Toast.LENGTH_SHORT).show();
            break;
        }

    }
});