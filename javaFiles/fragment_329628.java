if (_calendar.get(Calendar.DAY_OF_YEAR) == selectedDate.get(Calendar.DAY_OF_YEAR) &&
                            _calendar.get(Calendar.YEAR) == selectedDate.get(Calendar.YEAR)
 && _calendar.get(Calendar.MONTH) == shownMonth.get(Calendar.MONTH)) {
                        textColor = selectionTextColor;
                        backgroundColor = cellSelectionBackgroundColor;
       } else {
          if (_calendar.get(Calendar.MONTH) == shownMonth.get(Calendar.MONTH)) {
              textColor = this.textColor;
          } else {
              textColor = inactiveTextColor;
          }
          backgroundColor = cellBackgroundColor;
      }