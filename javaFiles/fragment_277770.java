@Override
public View getView(final int position, View convertView,
        final ViewGroup parent) {

    RelativeLayout rel = null;
    if (null == convertView) {

        String inflater = Context.LAYOUT_INFLATER_SERVICE;
        LayoutInflater vi;
        vi = (LayoutInflater) getContext().getSystemService(inflater);
        rel = (RelativeLayout) vi.inflate(resource, rel, true);

    } else {
        rel = (RelativeLayout) convertView;

    }
               LayoutParams params= (LayoutParams) rel.getLayoutParams();
         params.height=///some height;
                 rel.setLayoutParams(params);

         return rel;
}