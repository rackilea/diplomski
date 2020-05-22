Fragment fr = getSupportFragmentManager().getFragmentByTag("Fragment name");

@Override
public void onBackPressed() {

    if (fr != null)
    {
        getSupportFragmentManager().beginTransaction().replace(container, new PreviousFragment, "Tag").commit();
    }
    else
    {
        super.onBackPressed();
    }
}