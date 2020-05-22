protected override Java.Lang.Object DoInBackground(params Java.Lang.Object[] @params)
    {
        // filter the list
        this._adapter.filterStudents(this._filterText);
        return true;
    }