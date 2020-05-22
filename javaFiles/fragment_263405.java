if my UIscript_check(true) then

    if my do_submenu("Terminal", "Shell", "New Window", "Homebrew") then

        tell application "Terminal"

            -- here your script --
            do script "echo " & quoted form of "this is my script" in window 1

        end tell

        tell application "System Events"
            keystroke "f" using {control down, command down}
        end tell

    else
        beep
    end if

end if


on do_menu(app_name, menu_name, menu_item)
    try
        -- bring the target application to the front
        tell application app_name
            activate
        end tell
        tell application "System Events"
            tell process app_name
                tell menu bar 1
                    tell menu bar item menu_name
                        tell menu menu_name
                            click menu item menu_item
                        end tell
                    end tell
                end tell
            end tell
        end tell
        return true
    on error error_message
        return false
    end try
end do_menu

on do_submenu(app_name, menu_name, menu_item, submenu_item)
    try
        -- bring the target application to the front
        tell application app_name
            activate
        end tell
        tell application "System Events"
            tell process app_name
                tell menu bar 1
                    tell menu bar item menu_name
                        tell menu menu_name
                            tell menu item menu_item
                                tell menu menu_item
                                    click menu item submenu_item
                                end tell
                            end tell
                        end tell
                    end tell
                end tell
            end tell
        end tell
        return true
    on error error_message
        return false
    end try
end do_submenu

on UIscript_check(with_msg)
    -- get the system version
    set the hexData to system attribute "sysv"
    set hexString to {}
    repeat 4 times
        set hexString to ((hexData mod 16) as string) & hexString
        set hexData to hexData div 16
    end repeat
    set the OS_version to the hexString as string
    if the OS_version is less than "1030" then
        display dialog "This script requires the installation of Mac OS X 10.3 or higher." buttons {"Cancel"} default button 1 with icon 2
    end if
    -- check to see if assistive devices is enabled
    tell application "System Events"
        set UI_enabled to UI elements enabled
    end tell
    if UI_enabled is false then
        if (with_msg) then
            tell application "System Preferences"
                activate
                set current pane to pane "com.apple.preference.universalaccess"
                display dialog "This script utilizes the built-in Graphic User Interface Scripting architecture of Mac OS X which is currently disabled." & return & return & "You can activate GUI Scripting by selecting the checkbox \"Enable access for assistive devices\" in the Universal Access preference pane." with icon 1 buttons {"OK"} default button 1
            end tell
        end if
        return false
    else
        return true
    end if
end UIscript_check