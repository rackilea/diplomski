ListModel made_model = made_list.getModel(); // 1

Object[] orig_sel = orig_list.getSelectedItems(); // 2

Object[] new_made_model = new Object[made_model.size() + orig_sel.length]; // 3

// this block is 4
int i = 0;
for(;i < made_model.size(); i++) 
    new_made_model[i] = made_model.getElementAt(i);
for(; i < new_made_model.length; i++) 
    new_made_model[i] = orig_sel[i - made_model.size());

made_model.setListData(new_made_model); // 5