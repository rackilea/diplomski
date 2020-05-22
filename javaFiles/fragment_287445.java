buttonTest.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {

        try {
          Field mOnLayout = SwitchCompat.class.getDeclaredField("mOnLayout");
          Field mOffLayout = SwitchCompat.class.getDeclaredField("mOffLayout");

          mOnLayout.setAccessible(true);
          mOffLayout.setAccessible(true);

          mOnLayout.set(switchCompat, null);
          mOffLayout.set(switchCompat, null);
        } catch (NoSuchFieldException e) {
          e.printStackTrace();
        } catch (IllegalAccessException e) {
          e.printStackTrace();
        }

        switchCompat.setTextOn("YOO");
        switchCompat.setTextOff("NAH");

      }
    });