protected Dialog onCreateDialog(int paramInt)
    {
       switch (paramInt)
       {
         default:
         case 0:
       }
       for (Dialog localObject = null; ; localObject = this.dialog)
       {
          this.dialog = new ProgressDialog(this);
          this.dialog.setMessage(getResources().getString(2131165201));
          this.dialog.setIndeterminate(true);
          this.dialog.setCancelable(false);
          return localObject; // here problem cast
       }
      }