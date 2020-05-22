class YourController {

    def sessionFactory

    def index() {
        def scaffoldedTables = grailsApplication.controllerClasses.findAll{ it.isReadableProperty( 'scaffold' ) }.collectEntries {
            [(it.name): sessionFactory.getClassMetadata(it.getPropertyValue( 'scaffold', Object.class )).tableName]
        }

        [scaffoldedTables: scaffoldedTables]
    }
}