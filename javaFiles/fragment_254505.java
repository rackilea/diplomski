@Name("bean")
@Scope(ScopeType.SESSION)
class MyBean {
     ...

     public String getValue() {
          return value;
     }

     ...
}

@Name("otherBean")
@Scope(ScopeType.EVENT)
class MyBean {
     ...

     public String getInterpolatedValue() {
          return Interpolator.instance().interpolate("#{bean.value}");
     }

     ...

}