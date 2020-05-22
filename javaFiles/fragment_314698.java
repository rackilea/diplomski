Button[] buttons = {btnans1, btnans2, btnans3, btnans4};

    for (int i = 0; i < buttons.length; i++) {
        String text = buttons[i].getText().toString().trim();

        String[] words = text.split(" ");

        Float size;

        if (words.length > 5) {
            size = getResources().getDimension(R.dimen.btn_text_size_small);
        } else {
            size = getResources().getDimension(R.dimen.btn_text_size_normal);
        }

        buttons[i].setTextSize(TypedValue.COMPLEX_UNIT_PX, size);
    }