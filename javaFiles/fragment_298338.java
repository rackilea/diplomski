if (Link1.contains("www.")) {
    // Do nothing
} else {
    et1.setError("Link ist nicht gültig");
    et1.setHintTextColor(RED);
    return;   // Return from here
}

if (Link1.matches("") || Kategorie1.matches("")) {
    et.setHintTextColor(RED);
    et1.setHintTextColor(RED);
} else {
    i.putExtra("ersteActivityKategorie", Kategorie1);
    i.putExtra("ersteActivityLink", Link1);
    startActivity(i);
}