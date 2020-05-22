protected override Java.Lang.Object DoInBackground(params Java.Lang.Object[] @params)
    {
        // filter the list
        result = students.filterStudents(this._filterText);
        return true;
    }


protected override void OnPostExecute(Java.Lang.Object result)
        {
            // Notify adapter of Data Change (to trigger re-draw)
            this._adapter.SetItems(result);
            this._adapter.NotifyDataSetChanged();
            base.OnPostExecute(result);
        }