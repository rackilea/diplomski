if ( childFormLoaded )
            {
                if ( panelsControl.containsPanel( createMovie.class.getName() ) )
                    panelsControl.removePanel( createMovie.class.getName() );
            }
            else
            {
                if ( panelsControl.containsPanel( ParentClass.class.getName() ) )
                    panelsControl.removePanel( ParentClass.class.getName() );
            }