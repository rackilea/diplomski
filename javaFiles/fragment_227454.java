public class PageTransition {

    public static final String TAG = PageTransition.class.getSimpleName();
    private static int pageId;

    public static Fragment init(String id, String form) {
        Log.d(TAG, "currentPage: id " + id);
        pageId = Integer.valueOf(id); //set current page Id

        switch(form) {
            case "formA" :
                return formA_caseContent(id);
            case "formB" :
                return formB_caseContent(id);
            case "formC" :
                return formC_caseContent(id);
            default:
                Log.d(TAG, "currentPage: form id " + form + " out of bound.");
                return null;
        }
    }

    public static void pageContents(final Fragment fragment, int totalPage, final String form, String id, TextView next,
                                    TextView previous) {
        //change string string to int
        int pageID = Integer.parseInt(id);
        int prevID = 0, nextID = 0;

        if(pageID == 1) {
            previous.setVisibility(View.GONE); //hide prev button onn 1st page
            nextID = ++pageID;

        } else if (pageID > 1 && pageID < totalPage ) {
            prevID = --pageID;
            nextID = 2+pageID;

        } else if (pageID == totalPage) {
            next.setVisibility(View.GONE); //hide next button on last page
            prevID = --pageID;

        }

        final int finalNextID = nextID;
        next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Fragment _fragment = init(String.valueOf(finalNextID), form);
                    fragment.getFragmentManager().beginTransaction()
                            .replace(R.id.case_detail_container, _fragment).commit();
                }
            });

        final int finalPrevID = prevID;
        previous.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Fragment _fragment = init(String.valueOf(finalPrevID), form);
                    fragment.getFragmentManager().beginTransaction()
                            .replace(R.id.case_detail_container, _fragment).commit();
                }
            });

    }

    private static Fragment formA_caseContent(String id) {

        Bundle arguments = new Bundle();
        Fragment fragment;

        switch (id) {
            case "1":
                arguments.putString(FirstPage.ARG_ITEM_ID, id);
                fragment = new FirstPage();

                break;
            case"2":
                arguments.putString(SecondPage.ARG_ITEM_ID, id);
                fragment = new SecondPage();

                break;
            ....
            default:
                Log.i(TAG, "onSelectedMenuItem: Selection out of bound.");
                arguments.putString(FirstPage.ARG_ITEM_ID, id);
                fragment = new FirstPage();
                break;
        }

        fragment.setArguments(arguments);
        return fragment;
    }

    private static Fragment formB_caseContent(String id) {}

    private static Fragment formc_caseContent(String id) {}
}