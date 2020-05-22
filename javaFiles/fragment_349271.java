nama_pp.addTextChangedListener(new TextWatcher()
    {
        public void beforeTextChanged(CharSequence p1, int p2, int p3, int p4)
        {
            // TODO: Implement this method
        }

        public void afterTextChanged(Editable p1)
        {
            // TODO: Implement this method
        }

        public void onTextChanged(CharSequence s, int start, int before, int count)
        { 
            if(s.length() == 0)
            {
                image_status.setImageResource(R.drawable.espaj_yellow_checklist);
            }
            else
            {
                image_status.setImageResource(R.drawable.espaj_gray_checklist);
            }
        }
    }
);