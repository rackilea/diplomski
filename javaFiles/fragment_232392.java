public static SWIGTYPE_p_double new_double_array(int nelements) {
    long cPtr = SimulatorModuleJNI.new_double_array(nelements);
    return (cPtr == 0) ? null : new SWIGTYPE_p_double(cPtr, false);
  }

  public static void delete_double_array(SWIGTYPE_p_double ary) {
    SimulatorModuleJNI.delete_double_array(SWIGTYPE_p_double.getCPtr(ary));
  }

  public static double double_array_getitem(SWIGTYPE_p_double ary, int index) {
    return SimulatorModuleJNI.double_array_getitem(SWIGTYPE_p_double.getCPtr(ary), index);
  }

  public static void double_array_setitem(SWIGTYPE_p_double ary, int index, double value) {
    SimulatorModuleJNI.double_array_setitem(SWIGTYPE_p_double.getCPtr(ary), index, value);
  }