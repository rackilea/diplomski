Resources res = getResources();
        final TypedArray sounds = res.obtainTypedArray(R.array.sounds_array);
        int[] resIds = new int[sounds.length()];
        for (int i = 0; i < sounds.length(); i++) {
            resIds[i] = sounds.getResourceId(i, -1);
        }
sounds.recycle();