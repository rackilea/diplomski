class NoteItemImpl extends AbstractNoteItem { ... stuff ... }

Notelist notelist ; 
// implicit type argument specification
NotePanel < AbstractNoteItem > n1 = notelist . getPanelFromIndex ( 1 ) ;  
NotePanel < NoteItemImpl > n2 = notelist . getPanelFromIndex (2 ) ; // may generate class cast exception

// explicit type argument specification
NotePanel < AbstractNoteItem > n3 = notelist . < AbstractNoteItem > getPanelFromIndex ( 3 ) ;
NotePanel < NoteItemImpl > n4 = notelist . < NoteItemImpl > getPanelFromIndex ( 4 ) ; // may generate class cast exception