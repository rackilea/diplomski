private final String letters;
public LetterAdapter(Context c) {
    String lang = Locale.getDefault().getLanguage();
    if (lang.equals(new Locale("da").getLanguage())
        this.letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ\u00C6\u00D8\u00C5"; // Danish
    else if (lang.equals(new Locale("no").getLanguage())
        this.letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ\u00C6\u00D8\u00C5"; // Norwegian
    else if (lang.equals(new Locale("sv").getLanguage())
        this.letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ\u00C5\u00C4\u00D6"; // Swedish
    else if (lang.equals(new Locale("de").getLanguage())
        this.letters = "A\u00C4BCDEFGHIJKLMNO\u00D6PQRS\u00DFTU\u00DCVWXYZ"; // German
    else
        this.letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; // English (and others)

    letterInf = LayoutInflater.from(c);
}
public int getCount() {
    return this.letters.length();
}
public View getView(int position, View convertView, ViewGroup parent) {
    Button letterBtn;
    if (convertView == null) {
        letterBtn = (Button)letterInf.inflate(R.layout.letter, parent, false);
    } else {
        letterBtn = (Button) convertView;
    }
    letterBtn.setText(String.valueOf(this.letters.charAt(position)));
    return letterBtn;
}