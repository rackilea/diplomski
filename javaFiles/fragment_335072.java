import com.jacob.com.*;
import com.jacob.activeX.*;

static void setProperty(Dispatch d, String sName, String sIndex, String sValue) {
  Variant av[] = { new Variant(sIndex), new Variant(sValue) };
  Dispatch.invokev(d, sName, Dispatch.Put, av, NO_INT_ARGS).safeRelease();
  av[0].safeRelease(); av[1].safeRelease();
  }