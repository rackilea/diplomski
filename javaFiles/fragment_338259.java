parser grammar TestParser;

options { tokenVocab=TestLexer; }

rul   : block+ ;
block  : LBR STRING RBR ;