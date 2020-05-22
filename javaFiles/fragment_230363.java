List<Integer> list = new ArrayList<>();
        CheckBox ios = ...
        CheckBox android = ...
        ios.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked)
                list.add(2);
            else if (list.contains(2))
                list.remove(Integer.valueOf(2));
        });
        android.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked)
                list.add(4);
            else if (list.contains(4))
                list.remove(Integer.valueOf(4));
        });