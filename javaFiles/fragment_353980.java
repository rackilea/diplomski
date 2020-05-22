File dirs[] = ContextCompat.getExternalFilesDirs(getApplicationContext(),null);

        String Info = "getExternalFilesDirs()\ndirs.length: " + dirs.length;
        int nr = -1;            
        while ( ++nr < dirs.length )
            Info += "\n"+  dirs[nr].getAbsolutePath();

        Toast.makeText(this, Info, Toast.LENGTH_LONG).show();