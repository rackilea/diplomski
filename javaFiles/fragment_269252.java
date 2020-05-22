@Subcomponent.Builder
abstract class Builder extends AndroidInjector.Builder<MarcaFragment> {

  // This method tells Dagger you need to supply your own DIMarcoModulo.
  public abstract void diMarcoModulo(DIMarcaModulo modulo);

  // dagger.android calls this method automatically, but only this method, so
  // you'll need to call diMarcoModulo from it.
  @Override public void seedInstance(MarcaFragment fragment) {
    diMarcoModulo(fragment, fragment.getMMarcaAdapter());
    bindMarcaFragment(fragment);  // OPTIONAL: See below
  }

  // If you want MarcaFragment to remain injectable, you might need to call into
  // a different @BindsInstance method you define, because you've prevented
  // seedInstance from doing that for you.
  @BindsInstance public abstract void bindMarcaFragment(MarcaFragment fragment);
}