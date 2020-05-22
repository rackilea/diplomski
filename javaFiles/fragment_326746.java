final LayoutInflater inflater = LayoutInflater.from(MainActivity.this);

// tipo = 2 or 3
for (int i = 0; i < objetos_add.get(0).length; i++) {
    if (!objetos_add.get(0)[i].isEmpty()) {
        root.addView(getCustomView(inflater, tipo, objetos_add, i));
    }
}

// tipo = 1 or 3
for (for int i = 0; i < objetos_rem.get(0).length; i++) {
    if (!objetos_rem.get(0)[i].isEmpty()) {
        root.addView(getCustomView(inflater, tipo, objectos_rem, i));
    }
}