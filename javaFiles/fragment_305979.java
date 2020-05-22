@Override
public View getView(int position, View convertView, ViewGroup parent) {
    LayoutInflater inflater = (LayoutInflater) mContext
            .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

if(layout == LayoutTYPE_1){ //LollipopView

            // getItem(postion) will give you Object - downcast it as per the position.

            Runner runner = (LollipopRunner)(getItem(position)); //downcast to lollipopRunner

            gridView = inflater.inflate(R.layout.lollipopRunner, null); //use lollipopRunner XML
}else if(layout == LayoutTYPE_2){

            Runner runner = (BasicRunner)(getItem(position));  //downcasted to basic runner

        gridView = inflater.inflate(R.layout.basicrunner, null); //use basic runner XML