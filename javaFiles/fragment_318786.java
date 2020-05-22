public class EnumAlternativeValueHelperTest {


  private enum EnumUnderTest implements EnumAlternativeValue<String> {
    VALUE1("AlternativeName1"),
    VALUE2("AlternativeName2"),
    ;
    private final String alternativeName;
    private EnumUnderTest(String alternativeName) {
      this.alternativeName = alternativeName;
    }
    @Override
    public String getAlternativeValue() {
      return alternativeName;
    }
  }

  private enum EnumUnderTest2 implements EnumAlternativeValue<Integer> {
    VALUE1(1),
    VALUE2(2),
    ;
    private final int alternativeOrdinal;
    private EnumUnderTest2(int alternativeOrdinal) {
      this.alternativeOrdinal = alternativeOrdinal;
    }
    @Override
    public Integer getAlternativeValue() {
      return alternativeOrdinal;
    }
  }



  @Test
  public void getIfPresentReturnsValueTest() {
    assertThat( EnumAlternativeValueHelper.getIfPresent(EnumUnderTest.class,"AlternativeName1") )
            .isEqualTo(Optional.of(EnumUnderTest.VALUE1));
    assertThat( EnumAlternativeValueHelper.getIfPresent(EnumUnderTest2.class,1) )
            .isEqualTo(Optional.of(EnumUnderTest2.VALUE1));
  }
  @Test
  public void getIfPresentReturnsAbsent1Test() {
    assertThat( EnumAlternativeValueHelper.getIfPresent(EnumUnderTest.class,"AlternativeNameUnknown") )
            .isEqualTo( Optional.<EnumUnderTest>absent() );
    assertThat( EnumAlternativeValueHelper.getIfPresent(EnumUnderTest2.class,0) )
            .isEqualTo( Optional.<EnumUnderTest2>absent() );
  }
  @Test
  public void getIfPresentReturnsAbsentWhenNonAlternativeValueIsProvidedTest() {
    assertThat( EnumAlternativeValueHelper.getIfPresent(EnumUnderTest.class, EnumUnderTest.VALUE1.name()) )
            .isEqualTo( Optional.<EnumUnderTest>absent() );
    assertThat( EnumAlternativeValueHelper.getIfPresent(EnumUnderTest2.class, EnumUnderTest2.VALUE1.ordinal()) )
            .isEqualTo( Optional.<EnumUnderTest2>absent() );
  }
  @Test
  public void getIfPresentWhenBadAlternativeValueReturnsAbsentTest() {
    assertThat( EnumAlternativeValueHelper.getIfPresent(EnumUnderTest.class,null) )
            .isEqualTo(Optional.<EnumUnderTest>absent());
    assertThat( EnumAlternativeValueHelper.getIfPresent(EnumUnderTest2.class,null) )
            .isEqualTo(Optional.<EnumUnderTest2>absent());
  }



  @Test
  public void valueOfReturnsValueTest() {
    assertThat( EnumAlternativeValueHelper.valueOf(EnumUnderTest.class, "AlternativeName1") )
            .isEqualTo( EnumUnderTest.VALUE1 );
    assertThat( EnumAlternativeValueHelper.valueOf(EnumUnderTest2.class, 1) )
            .isEqualTo( EnumUnderTest2.VALUE1 );
  }
  @Test(expected = NullPointerException.class)
  public void valueOfThrowsExceptionTest() {
    EnumAlternativeValueHelper.valueOf(EnumUnderTest.class, "AlternativeNameUnknown");
    EnumAlternativeValueHelper.valueOf(EnumUnderTest2.class, 0);
  }
  @Test(expected = NullPointerException.class)
  public void valueOfThrowsExceptionWhenBadAlternativeValueTest() {
    EnumAlternativeValueHelper.valueOf(EnumUnderTest.class, null);
    EnumAlternativeValueHelper.valueOf(EnumUnderTest2.class, null);
  }
  @Test(expected = NullPointerException.class)
  public void valueOfThrowsExceptionWhenNonAlternativeValueIsProvidedTest() {
    EnumAlternativeValueHelper.valueOf(EnumUnderTest.class, EnumUnderTest.VALUE1.name());
    EnumAlternativeValueHelper.valueOf(EnumUnderTest2.class, EnumUnderTest.VALUE1.ordinal());
  }


  @Test
  public void nullSafeValueOfReturnsValueTest() {
    assertThat(EnumAlternativeValueHelper.valueOfNullSafe(EnumUnderTest.class, "AlternativeName1"))
            .isEqualTo(Optional.of(EnumUnderTest.VALUE1));
    assertThat(EnumAlternativeValueHelper.valueOfNullSafe(EnumUnderTest2.class, 1))
            .isEqualTo(Optional.of(EnumUnderTest2.VALUE1));
  }
  @Test(expected = NullPointerException.class)
  public void nullSafeValueOfThrowsExceptionTest() {
    EnumAlternativeValueHelper.valueOfNullSafe(EnumUnderTest.class, "AlternativeNameUnknown");
    EnumAlternativeValueHelper.valueOfNullSafe(EnumUnderTest2.class, 1);
  }
  @Test
  public void nullSafeValueOfReturnsAbsentWhenBadAlternativeValueTest() {
    assertThat( EnumAlternativeValueHelper.valueOfNullSafe(EnumUnderTest.class, null) )
            .isEqualTo(Optional.<EnumUnderTest>absent());
    assertThat( EnumAlternativeValueHelper.valueOfNullSafe(EnumUnderTest2.class, null) )
            .isEqualTo(Optional.<EnumUnderTest2>absent());
  }
  @Test(expected = NullPointerException.class)
  public void nullSafeValueOfThrowsExceptionWhenNonAlternativeValueIsProvidedTest() {
    EnumAlternativeValueHelper.valueOf(EnumUnderTest.class, EnumUnderTest.VALUE1.name());
    EnumAlternativeValueHelper.valueOf(EnumUnderTest2.class, EnumUnderTest.VALUE1.ordinal());
  }



  @Test
  public void alternativeValueFunctionTest() {
    assertThat(EnumAlternativeValueHelper.<String>getAlternativeValueFunction().apply(EnumUnderTest.VALUE1)).isEqualTo("AlternativeName1");
    assertThat(EnumAlternativeValueHelper.<Integer>getAlternativeValueFunction().apply(EnumUnderTest2.VALUE1)).isEqualTo(1);
  }