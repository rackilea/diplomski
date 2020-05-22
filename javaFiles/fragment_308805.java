switch (titlePosition) {
      case ABOVE_TOP:
      case TOP:
      case BELOW_TOP:
      case ABOVE_BOTTOM:
      case BOTTOM:
      case BELOW_BOTTOM:
      case DEFAULT_POSITION:
            this.titlePosition = titlePosition;
            break;
      default:
        throw new IllegalArgumentException(titlePosition +
                                    " is not a valid title position.");
    }