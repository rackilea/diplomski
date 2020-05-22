function keypress_callback_test()
hf = figure();
he=uicontrol('Parent',hf,'Style','edit', 'String', '0');

jhe = findjobj(he, 'nomenu');
set(jhe,'KeyPressedCallback', {@change_text, he});


function change_text(hObject, event, he)
set(he, 'String', num2str(rand(1)))