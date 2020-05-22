@Override
public Fragment getItem(int position) {         
    String drugName = drugsList.get(position).getName();
    String description = drugsList.get(position).getDescription();
    String category = drugsList.get(position).getCategory();

    return DrugsFragment.newInstance(drugName, description,category);
}