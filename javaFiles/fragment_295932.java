@Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            view = inflater.inflate (R.layout.list_main, null);
            TextView textView = (TextView) view.findViewById (R.id.textView);
            String upper = thisList.get (i).toString ().substring (0,1).toUpperCase () + thisList.get (i).toString ().substring (1);
            TextView boxText = (TextView) view.findViewById (R.id.boxText);
            TextView boxView = (TextView) view.findViewById (R.id.boxView);
            String first = thisList.get (i).toString ().toUpperCase ().substring (0,1);
            textView.setText (upper);
            boxText.setText (first);
            return view;
        }
    }