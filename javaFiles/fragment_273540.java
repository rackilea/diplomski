Fragment f;
        f = new CardBackFragment();
        // Then just replace the recycler view fragment as usually
        ((FragmentActivity) context).getFragmentManager().beginTransaction()
                .setCustomAnimations(
                        R.animator.card_flip_right_in,
                        R.animator.card_flip_right_out,
                        R.animator.card_flip_left_in,
                        R.animator.card_flip_left_out)
                .addToBackStack(null)
                .replace(newContainerId, f).commit();
        // Once all fragment replacement is done we can show the hidden container
        handler.post(runnable);