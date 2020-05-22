// -- container for all of our list items
List<Map<String, String>> groupData = new ArrayList<Map<String, String>>();

// -- list item hash re-used
Map<String, String> group;

// -- create record
group = new HashMap<String, String>();

group.put( KEY_LABEL, getString( R.string.option_create ) );
group.put( KEY_HELP,  getString( R.string.option_create_help ) );
group.put( KEY_ACTION, ACTION_CREATE_RECORD );

groupData.add(group);

// -- geo locate
group = new HashMap<String, String>();

group.put( KEY_LABEL, getString(R.string.option_geo_locate ) );
group.put( KEY_HELP, getString(R.string.option_geo_locate_help ) )
group.put( KEY_ACTION, ACTION_GEO_LOCATE );

groupData.add( group );

// -- take photo
group = new HashMap<String, String>();

group.put( KEY_LABEL, getString( R.string.option_take_photo ) );
group.put( KEY_HELP, getString(R.string.option_take_photo_help ) );
group.put( KEY_ACTION, ACTION_TAKE_PHOTO );

groupData.add( group );

// -- create an adapter, takes care of binding hash objects in our list to actual row views
SimpleAdapter adapter = new SimpleAdapter( this, groupData, android.R.layout.simple_list_item_2, 
                                                   new String[] { KEY_LABEL, KEY_HELP },
                                                   new int[]{ android.R.id.text1, android.R.id.text2 } );
setListAdapter( adapter );