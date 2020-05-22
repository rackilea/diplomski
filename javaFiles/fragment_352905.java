try {
        startActivity(intent);
    } catch (ActivityNotFoundException e) {
        Toast.makeText(myactivity .this,
                "No Application Available to View PDF", Toast.LENGTH_LONG).show();
    }