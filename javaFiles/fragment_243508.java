public class Global extends GlobalSettings {
  static {
   play.data.format.Formatters.register(ProjectionSet.class,
                                new Formatters.SimpleFormatter<ProjectionSet>() {
        @Override
        public ProjectionSet parse(String id, Locale locale) throws ParseException {
            ProjectionSet pSet = null;
            try {
                long tmpId = Long.parseLong(id);
                pSet = ProjectionSet.finder.byId(tmpId);
            } catch (NumberFormatException ignored) {
                //unexpected id
            }
            return pSet;
        }

        @Override
        public String print(ProjectionSet pSet , Locale locale) {
            return pSet.id + "";
        }
    });
  }
}