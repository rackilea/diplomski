case 1:
    rootView = inflater.inflate(R.layout.fragmenttemplate_admin_control_tabbed, container, false);

    GridView templateGrid = (GridView) rootView.findViewById(R.id.templateGrid);

    for (int i = 0; i < templateIcons.length; i++){
        templateIButtons.add(new ImageButton(getContext()));
        templateIButtons.get(i).setImageResource(templateResources[i]);
        templateIButtons.get(i).setBackgroundColor(Color.TRANSPARENT);
        templateIButtons.get(i).setId(i);
    }

    templateGrid.setAdapter(new ArrayAdapter<ImageButton>(getContext(),android.R.layout.simple_list_item_1, templateIButtons));

    break;