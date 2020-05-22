Spinner spinner = FindViewById<Spinner>(Resource.Id.mySpinner);
        spinner.ItemSelected += new EventHandler<AdapterView.ItemSelectedEventArgs>(spinner_ItemSelected);

        ArrayAdapter adapter = new ArrayAdapter(this,
                                                Resource.Layout.multiline_spinner_dropdown_item,
                                                new Taxonomy[] { new Taxonomy( 123, "option1"), 
                                                                 new Taxonomy( 124, "option2"), 
                                                                 new Taxonomy( 125, "option3"), 
                                                                 new Taxonomy( 126, "option4") });
        adapter.SetDropDownViewResource(Android.Resource.Layout.SimpleSpinnerDropDownItem);
        spinner.Adapter = adapter;