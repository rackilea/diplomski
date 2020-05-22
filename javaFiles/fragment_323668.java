Function<SomeObject, String> using;
if(<some condition>) {
   using = (a) => a.land;
} else {
   using = (a) => a.stad;
}


"What's the capital in " + using.apply(nyttLista.get(slumpLand)) + "?";