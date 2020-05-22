case 0:
    result = data.getStringExtra("text");
    name = data.getStringExtra("a");
    description = data.getStringExtra("c");
    as = Long.parseLong(result);
    Log.d("FIRST", "result:"+result);
    Text="  "+name+"                                  "+"RM"+result+"";
    if (m_listItems.size() == 0) {
        m_listItems.add(Text);
    } else {
        m_listItems.set(mClickedPosition,Text);
    }
    adapter.notifyDataSetChanged();
    listV.setAdapter(adapter);

    break;