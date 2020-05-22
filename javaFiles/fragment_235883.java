@Override
public Fragment getItem(int position) {
    Bundle bundle = new Bundle();
    if(position == 0){
        bundle.putInt("position", position);
        bundle.putString("survayType", "your value");
        mFragmentList.get(position).setArguments(bundle);
    }else if(position == 1){
        bundle.putInt("position", position);
        bundle.putString("survayType", "your value");
        mFragmentList.get(position).setArguments(bundle);
    }else if(position == 2){
        bundle.putInt("position", position);
        bundle.putString("survayType", "your value");
        mFragmentList.get(position).setArguments(bundle);
    }else if(position == 3){
        bundle.putInt("position", position);
        bundle.putString("survayType", "your value");
        mFragmentList.get(position).setArguments(bundle);
    }else if(position == 4){
        bundle.putInt("position", position);
        bundle.putString("survayType", "your value");
        mFragmentList.get(position).setArguments(bundle);
    }

    return mFragmentList.get(position);
}