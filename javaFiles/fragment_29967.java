if (hashMap.remove(word) != null) {
    Toast.makeText(MainActivity.this, "ok", Toast.LENGTH_SHORT)
            .show();
} else {
    Toast.makeText(MainActivity.this, "not found", Toast.LENGTH_SHORT)
            .show();
}