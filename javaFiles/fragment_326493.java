protected override void OnCreate(Bundle bundle)
{
    base.OnCreate(bundle);

    SetContentView(Resource.Layout.Main);

    var editText = FindViewById<EditText>(Resource.Id.EditText);
    var ssb = new SpannableStringBuilder(new string('E', 250));
    editText.SetText(ssb, TextView.BufferType.Editable);
    ssb.SetSpan(new ForegroundColorSpan(Color.Blue), 0, ssb.Length(), SpanTypes.InclusiveExclusive);
}