@Override
public Object instantiateItem( View pager, int position )
{
    LayoutInflator inflator = LayoutInflator.from( context );
    View v = null;
    switch( position )
    {
        case 0:
            v = inflator.inflate( R.layout.layout1, (ViewPager)pager, false );
            break;
        case 1:
            v = inflator.inflate( R.layout.layout2, (ViewPager)pager, false );
            break;
        .
        .
        .
    }
    v.setText(titles[position]);

    ((ViewPager)pager).addView(v,0);

    return v;
}