@Override
public View getView(int position, View convertView, ViewGroup parent) {

    LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    View v;
    if (convertView == null) {
       v = inflater.inflate(R.layout.single_word_container_item, null); 
    } else {
       v = convertView;
    }
    TextView wordName = (TextView) v.findViewById(R.id.wordName);

    // questionable logic
    if(!_words.isEmpty()){
        wordName.setText(_word.remove(0));
    }

    return v;
}