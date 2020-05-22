parser grammar TParser;

options {
  tokenVocab=TLexer;
}

parse
 : atom* EOF
 ;

atom
 : text
 | function
 ;

text
 : TEXT+
 ;

function
 : ID params
 ;

params
 : PAR_OPEN ( param ( COMMA param )* )? PAR_CLOSE
 ;

param
 : NUMBER
 | STRING
 | function
 ;