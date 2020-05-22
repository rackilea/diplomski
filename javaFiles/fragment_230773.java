Spannable WordtoSpan = new SpannableString("Salida de la Capilla de María Auxiliadora\n00:00\nMarquesa de Sales\n00:00\nEspíritu Santo\n00:00\nSagasta\n00:00\nPza. Meneses\n00:00\nPozo Nuevo\n00:00\nPza. Ayuntamiento\n00:00\nSan Miguel\n00:00\nEstación de Penitencia, Iglesia San Miguel\n00:00\nÁnimas\n00:00\nMariano Hernández\n00:00\nEduardo Dato\n00:00\nRojas Marcos\n00:00\nPza. Meneses\n00:00\nCarrera\n00:00\nCalzadilla\n00:00\nGregorio María Ferro\n00:00\nMaría Auxiliadora\n00:00\nMarquesa de Sales\n00:00\nEntrada al Templo\n00:00\n");

    String search = new String("00:00");
    int length = search.length();
    String input = WordtoSpan.toString();
    int startIndex = input.indexOf(search);
    while(startIndex > length)
    {
        WordtoSpan.setSpan(new ForegroundColorSpan(Color.rgb(140, 117, 189)), startIndex, startIndex + length,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        WordtoSpan.setSpan(new StyleSpan(Typeface.BOLD), startIndex, startIndex + length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        startIndex = input.indexOf(search, startIndex + length);
    }