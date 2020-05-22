<?php
    //generate random consonants separated by vowels
    function generate_faux_word($letters = 5){

        //define arrays of consonants and vowels
        //no q, it's tough to remember
        $consonants = array('b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'r', 's', 't', 'v', 'w', 'x', 'y', 'z');
        $vowels = array('a', 'e', 'i', 'o', 'u');

        $ret_word = "";
        $consonant_toggle = true;
        //randomly choose a consonant then a vowel until the word is as long as the parameter
        while(strlen($ret_word) < $letters){
            if ($consonant_toggle){
                $ret_word .= $consonants[array_rand($consonants)];
                $consonant_toggle = false;
            }else{
                $ret_word .= $vowels[array_rand($vowels)];
                $consonant_toggle = true;
            }

        }

        return $ret_word;
    }

    echo generate_faux_word();
    echo "<br />";
    echo generate_faux_word();
    echo "<br />";
    echo generate_faux_word(6);
    echo "<br />";
    echo generate_faux_word(4);

?>