String[] foods = {"Bang Bang Shrimp", "Moroccan Fish Skewers", "Broiled Salmon Herbed Couscous", "Chilean Sea Bass", "Blackened Fish Tacos", "Argentinian Style Cod"};

ListAdapter recipeAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, foods);
ListView recipeListView = (ListView) findViewById(R.id.recipeListView);
recipeListView.setAdapter(recipeAdapter);
recipeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                switch (position) {
                    case 0:
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://thegirlonbloor.com/bang-bang-shrimp-bibimbap-noodle-bowls/")));
                        break;

                    case 1:
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://jellytoastblog.com/moroccan-fish-skewers/")));
                        break;

                    case 2:
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.mykitchenlove.com/15-minute-dinner-broiled-salmon-herbed-couscous-salad/")));
                        break;

                    case 3:
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://kitchenswagger.com/recipes/blackened-fish-tacos-recipe/")));
                        break;

                    case 4:
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://thatovenfeelin.com/chilean-sea-bass-bag-en-papillote/")));
                        break;

                    case 5:
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.twoofakindcooks.com/argentinian-style-cod-sauteed-vegetables/")));
                        break;


                }
            }
        });