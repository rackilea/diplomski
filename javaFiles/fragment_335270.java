Module module_data[] = new Module[moduleInfo.getCount()];
    int i;
    for(i=0; i<7; i++) {
        module_data[i] = new Module(moduleInfo.getString(1), moduleInfo.getString(2),  "済み： " + moduleStats.getString(7), moduleStats.getInt(4));
        moduleInfo.moveToNext();
        moduleStats.movetoNext();
    }